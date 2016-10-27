package es.flaviojmend.persistence.entity;

import javax.persistence.*;

/**
 * Created by flavio.mendes on 29/08/2016.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idPost;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_post_category")
    private PostCategory postCategory;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
