package templet;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: 牛虻.
 * time:2018/1/31
 * email:pettygadfly@gmail.com
 * doc:
 */
@RequestMapping(value = "/templetAction")
public class TempletAction {

//    @Resource
//    private TempletService templetService;

    @RequestMapping(value = "/test")
    public String test() {
        return "";
    }

    @RequestMapping(value = "/save")
    public String save() {
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete() {
        return "";
    }

    @RequestMapping(value = "/update")
    public String update() {
        return "";
    }

    @RequestMapping(value = "/query")
    public String query() {
        return "";
    }

    @RequestMapping(value = "/pagequery")
    public String getList() {
        return "";
    }

}
