package com.gnnu.feign;

import com.gnnu.entity.Class;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient("web-class")
public interface ClassFeign {

    @RequestMapping("/class/selectByCid/{cid}")
    @ResponseBody
    Class selectByCid(@PathVariable Integer cid);

    @RequestMapping("/class/selectClassesByTid/{tid}")
    @ResponseBody
    List<Class> selectClassesByTid(@PathVariable Integer tid);
}
