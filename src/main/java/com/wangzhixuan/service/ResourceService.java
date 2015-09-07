package com.wangzhixuan.service;

import java.util.List;

import com.wangzhixuan.model.Resource;
import com.wangzhixuan.model.User;
import com.wangzhixuan.vo.Tree;

public interface ResourceService {

    List<Tree> findTree(User currentUser);

    List<Resource> findTreeGrid();

    void addResource(Resource resource);

    List<Tree> findAllTree(boolean flag);

}
