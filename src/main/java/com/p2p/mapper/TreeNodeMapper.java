package com.p2p.mapper;

import com.p2p.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeMapper {

    //查询(得到最大的父节点)
     List<TreeNode> listAll();

     //
     List<TreeNode> initChildren(int treeNodeId);

    List<TreeNode> initChildren2(TreeNode treeNode);


}