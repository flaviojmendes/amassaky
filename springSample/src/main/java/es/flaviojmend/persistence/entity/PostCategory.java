package es.flaviojmend.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by flavio.mendes on 29/08/2016.
 */
@Entity
public class PostCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idPostCategory;
    private String categoryName;

    public Long getIdPostCategory() {
        return idPostCategory;
    }

    public void setIdPostCategory(Long idPostCategory) {
        this.idPostCategory = idPostCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
