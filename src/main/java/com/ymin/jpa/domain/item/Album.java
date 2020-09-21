package com.ymin.jpa.domain.item;

import com.ymin.jpa.domain.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

}
