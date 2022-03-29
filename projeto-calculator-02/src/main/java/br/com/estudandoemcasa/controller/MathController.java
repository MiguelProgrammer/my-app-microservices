package br.com.estudandoemcasa.controller;

import br.com.estudandoemcasa.entity.Person;
import br.com.estudandoemcasa.services.MathServices;
import br.com.estudandoemcasa.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math/operation")
public class MathController {

    @Autowired
    private MathServices mathServices;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathServices.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathServices.subtraction(numberOne, numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathServices.division(numberOne, numberTwo);
    }

    @RequestMapping(value = "/times/{numberOne}/{numberTwo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Double times(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathServices.times(numberOne, numberTwo);
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathServices.media(numberOne, numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{numberOne}/{numberTwo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String squareRoot(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathServices.squareRoot(numberOne, numberTwo);
    }
}
