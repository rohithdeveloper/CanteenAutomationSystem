package com.cg.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CanteenStaffDto {
	 private Long staffId;
    @NotBlank(message = "enter the staff name")
     private String staffName;
    @Email(message = "enter in abc@xyz.com format")
     private String staffEmail;

}
