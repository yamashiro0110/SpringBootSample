package sample.boot.api;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/hoge")
public class HogeController {

    @RequestMapping(value = "hoge", method = GET)
    public Hoge hoge() {
        return new Hoge();
    }

    @RequestMapping(value = "fuga", method = GET)
    public Fuga fuga() {
        return new Fuga();
    }

    @RequestMapping(value = "hogefuga", method = GET)
    public HogeFuga hogeFuga() {
        return new HogeFuga();
    }

    @RequestMapping(value = "hogefuga/list", method = GET)
    public HogeFugaList hogeFugaList() {
        return new HogeFugaList();
    }

    @Data
    public static class Hoge {
        private String name = "hoge";
        private List<String> list = Arrays.asList("hoge", "hoge", "hoge");
    }

    @Data
    public static class Fuga {
        private String name = "fuga";
        private HashMap map = new HashMap();

        {
            map.put("key1", "fuga");
            map.put("key2", "Fuga");
        }
    }

    @Data
    public static class HogeFuga {
        private String name = "hogefuga";
        private Hoge hoge = new Hoge();
        private Fuga fuga = new Fuga();
    }

    @Data
    public static class HogeFugaList {
        private String name = "";
        private List<String> hoge = Collections.emptyList();
        private Fuga fuga = new Fuga();
    }

}
