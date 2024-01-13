package htwberlin.webtech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Ein Controller für die HelloWorld-Ansicht.
 */
@Controller
public class HelloWorldController {

    @GetMapping(path = "/")
    public ModelAndView showHelloWorldPage() {
        return new ModelAndView("helloWorld");
    }
}
