package com.rei.jacksonencrypt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rei.jacksonencrypt.hashing.JsonObjectToHashSerializer;
import com.rei.jacksonencrypt.hashing.ObjectToHashSerializer;
import com.rei.jacksonencrypt.views.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonView({Views.Hashed.class, Views.Plain.class})
@JsonSerialize(using = JsonObjectToHashSerializer.class, as=Object.class)
public class Employer {

    private String name;

}
