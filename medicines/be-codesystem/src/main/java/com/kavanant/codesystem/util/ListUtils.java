package com.kavanant.codesystem.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListUtils {

    public static <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {

        if(pageSize <= 0 || page <= 0) {
            throw new IllegalArgumentException("Page Size shoud be > 0 or Page Number should be >=0");
        }

        int fromIndex = (page - 1) * pageSize;
        if(sourceList == null || sourceList.size() < fromIndex){
            return Collections.emptyList();
        }

        // toIndex exclusive
        return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
    }

    public static <T> void doPaginated(Collection<T> fullList, Integer pageSize, Page<T> pageInterface) {

        final List<T> list = new ArrayList<T>(fullList);
        if (pageSize == null || pageSize <= 0 || pageSize > list.size()){
            pageSize = list.size();
        }

        final int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
        for (int pageNum = 0; pageNum < numPages;){
            final List<T> page = list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size()));
            pageInterface.run(page);
        }
    }

    public interface Page<T> {
        void run(List<T> item);
    }
}