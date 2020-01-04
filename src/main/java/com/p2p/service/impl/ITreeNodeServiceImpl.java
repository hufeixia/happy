package com.p2p.service.impl;

import com.p2p.mapper.TreeNodeMapper;
import com.p2p.model.TreeNode;
import com.p2p.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITreeNodeServiceImpl implements ITreeNodeService {

    @Autowired
    TreeNodeMapper treeNodeMapper;


    @Override
    public List<TreeNode> listAll() {
        return treeNodeMapper.listAll();
    }

    @Override
    public List<TreeNode> initChildren(int treeNodeId) {
        return treeNodeMapper.initChildren(treeNodeId);
    }

    @Override
    public List<TreeNode> initChildren2(TreeNode treeNode) {
        return treeNodeMapper.initChildren2(treeNode);
    }
}
