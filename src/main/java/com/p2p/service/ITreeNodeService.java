package com.p2p.service;

import com.p2p.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ITreeNodeService {

    //查询(得到最大的父节点)
    List<TreeNode> listAll();

    //
    List<TreeNode> initChildren(int treeNodeId);

    List<TreeNode> initChildren2(TreeNode treeNode);

}