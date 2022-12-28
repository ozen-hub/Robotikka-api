package com.bootcamp.robotikka.robotikkaapi.entity.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FileResource {
    private String directory;
    private String hash;
    private String resource_url;
    private String file_name;
}
