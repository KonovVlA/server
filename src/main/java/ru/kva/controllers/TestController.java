package ru.kva.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    private static final List<String> rq = new ArrayList<>();
    private static final Map<String, Object> rs = new HashMap<>();

    @PostMapping("/put-url")
    public Object putUrl(@RequestBody Map<String, String> body) {
        var url = body.get("url");
        rq.add(url);
        while (true) {
            if (rs.get(url) != null) {
                var ttt = rs.get(url);
                rs.remove(url);
                return ttt;
            }
        }
    }

    @GetMapping("/get-url")
    public String getUrl() {
        if (rq.isEmpty()) {
            return null;
        }
        String result = rq.get(0);
        rq.remove(0);
        return result;
    }

    @PostMapping("/put-dep")
    public String putDep(@RequestBody Map<String, Object> body) {
        rs.put(body.get("url").toString(), body);
        return "OK";
    }

}
