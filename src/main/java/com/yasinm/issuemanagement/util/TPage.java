package com.yasinm.issuemanagement.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
@Data
public class TPage<T> {

    private int number; //kacinci sayfa gorunuyor
    private int size; // kac kayit gelecek
    private Sort sort; //herhangi bir colonu sıralayacak
    private int totalPages; //taplamda kac sayfa olustu
    private Long totalElements; // toplamda kac kayit var
    private List<T> content; // donecegim data

    public void setStat(Page page, List<T> list){
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }
}
