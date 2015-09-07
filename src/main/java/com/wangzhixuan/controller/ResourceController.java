package com.wangzhixuan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangzhixuan.code.Result;
import com.wangzhixuan.model.Resource;
import com.wangzhixuan.model.User;
import com.wangzhixuan.service.ResourceService;
import com.wangzhixuan.vo.Tree;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {
    
    private static Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    /**
     * @Description：菜单树
     * @return
     * @author：Wangzhixuan
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public List<Tree> tree() {
        User currentUser = getCurrentUser();
        List<Tree> tree = resourceService.findTree(currentUser);
        return tree;
    }

    /**
     * @Description：资源管理
     * @return
     * @author：Wangzhixuan
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
        return "admin/resource";
    }

    @RequestMapping(value = "/treeGrid", method = RequestMethod.POST)
    @ResponseBody
    public List<Resource> treeGrid() {
        List<Resource> treeGrid = resourceService.findTreeGrid();
        return treeGrid;
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "/admin/resourceAdd";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Resource resource) {
        Result result = new Result();
        try {
            resourceService.addResource(resource);
            result.setSuccess(true);
            result.setMsg("添加成功！");
        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }


    @RequestMapping("/allTree")
    @ResponseBody
    public List<Tree> allTree() {
        return resourceService.findAllTree();
    }

//    @RequestMapping("/treeGrid")
//    @ResponseBody
//    public List<Resource> treeGrid() {
//        List<Resource> treeGrid = resourceService.treeGrid();
//        String ResultString = Result.toResultString(treeGrid);
//        return resourceService.treeGrid();
//    }

//
//    @RequestMapping("/get")
//    @ResponseBody
//    public Resource get(Long id) {
//        return resourceService.get(id);
//    }
//
//    @RequestMapping("/editPage")
//    public String editPage(HttpServletRequest request, Long id) {
//        Resource r = resourceService.get(id);
//        request.setAttribute("resource", r);
//        return "/admin/resourceEdit";
//    }
//
//    @RequestMapping("/edit")
//    @ResponseBody
//    public Result edit(Resource resource) throws InterruptedException {
//        Result j = new Result();
//        try {
//            resourceService.edit(resource);
//            j.setSuccess(true);
//            j.setMsg("编辑成功！");
//        } catch (Exception e) {
//            j.setMsg(e.getMessage());
//        }
//        return j;
//    }
//
//    @RequestMapping("/delete")
//    @ResponseBody
//    public Result delete(Long id) {
//        Result j = new Result();
//        try {
//            resourceService.delete(id);
//            j.setMsg("删除成功！");
//            j.setSuccess(true);
//        } catch (Exception e) {
//            j.setMsg(e.getMessage());
//        }
//        return j;
//    }

}
