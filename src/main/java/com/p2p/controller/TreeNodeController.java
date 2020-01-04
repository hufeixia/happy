package com.p2p.controller;

import com.p2p.model.TreeNode;
import com.p2p.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TreeNodeController {

    @Autowired
    private ITreeNodeService treeNodeService;

    @RequestMapping(value = "/listAll")
    @CrossOrigin
    public @ResponseBody List listAll(){
        List<TreeNode> treeNodes = treeNodeService.listAll();
        for (TreeNode treeNode : treeNodes) {
            this.initChider(treeNode);
        }
        return treeNodes;
    }

    public void initChider(TreeNode treeNode){
        List<TreeNode> treeNodes = treeNodeService.initChildren2(treeNode);
        treeNode.setChildren(treeNodes);
        for (TreeNode node : treeNodes) {
            this.initChider(node);
        }
    }
}
