package com.meetup.meetup.users.domain;

import com.meetup.meetup.comments.domain.Comment;
import com.meetup.meetup.common.domain.BaseTimeEntity;
import com.meetup.meetup.likes.domain.Like;
import com.meetup.meetup.moims.domain.UserToMoim;
import com.meetup.meetup.users.dtos.UserResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String password;

    @Embedded
    private Address address;

    private String picture;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserToMoim> userToMoims = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public User(String email, String password, Address address, String picture, Role type) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.picture = picture;
        this.role = type;
    }

    public UserResponseDto toResponseDto() {
        return new UserResponseDto(email, picture, role);
    }

    public void update(String password, Address address, String picture) {
        if (password != null || password.equals("")) {
            this.password = password;
        }

        if (address != null) {
            this.address = address;
        }

        if (picture != null || picture.equals("")) {
            this.picture = picture;
        }
    }
}