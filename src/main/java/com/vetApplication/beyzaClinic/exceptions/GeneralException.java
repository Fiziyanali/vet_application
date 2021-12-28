package com.vetApplication.beyzaClinic.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private GeneralResult generalResult;
}