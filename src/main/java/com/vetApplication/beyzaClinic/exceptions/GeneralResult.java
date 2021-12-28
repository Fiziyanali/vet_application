package com.vetApplication.beyzaClinic.exceptions;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResult {
    private String errorCode;
    private String errorMessage;
}
