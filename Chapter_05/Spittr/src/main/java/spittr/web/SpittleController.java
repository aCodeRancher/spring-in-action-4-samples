package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private SpittleRepository spittleRepository;

  @Autowired
  public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return spittleRepository.findSpittles(max, count);
  }

  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
  public String spittle(
      @PathVariable("spittleId") long spittleId, 
      Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
  }

  @RequestMapping(method=RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) throws Exception {
    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), 
        form.getLongitude(), form.getLatitude()));
    return "redirect:/spittles";
  }



  @RequestMapping( value="/retrieve", method=RequestMethod.GET)
  public ResponseEntity<List<Spittle>> retrieveSpittle ()
  {
    List<Spittle> spittles = spittleRepository.findSpittles(20,20);
    return new ResponseEntity<List<Spittle>>(spittles, HttpStatus.OK);
  }

  @RequestMapping( value="/add", method=RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<Spittle> addSpittle (@RequestBody Spittle spittle)
  {
      spittleRepository.save(spittle);
    return new ResponseEntity<>(spittle, HttpStatus.CREATED);
  }
}
