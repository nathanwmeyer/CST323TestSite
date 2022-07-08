package com.example.demo.data.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTS")
public class ProductEntity {
    @Id
    @Column("ID")
	private Long id;

    @Column("NAME")
	private String name;
	
	@Column("COST")
	private Float cost;

    @Column("DESCRIPTION")
    private String description;

    public ProductEntity() {}

    public ProductEntity(Long id, String name, Float cost, String description)
    {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public ProductEntity( String name, Float cost, String description)
    {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Float getCost()
    {
        return cost;
    }

    public void setCost(Float cost)
    {
        this.cost = cost;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
