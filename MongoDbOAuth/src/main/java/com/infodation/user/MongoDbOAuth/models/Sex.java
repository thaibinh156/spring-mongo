package com.infodation.user.MongoDbOAuth.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Sex {
    MALE, FEMALE
}
