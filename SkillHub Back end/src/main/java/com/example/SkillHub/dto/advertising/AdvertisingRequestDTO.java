package com.example.SkillHub.dto.advertising;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AdvertisingRequestDTO(@NotBlank(message = "Campo requerido")
                                    @Size(min = 3, max = 80, message = "Título precisa ter de 3 a 80 caracteres")
                                    String title,

                                    @NotBlank(message = "Campo requerido")
                                    @Size(min = 10, message = "Descrição precisa ter no mínimo 80 caracteres")
                                    String description,

                                    @Positive
                                    Double price,
                                    String imgUrl,

                                    @NotBlank(message = "Campo requerido")
                                    Long jobId,

                                    @NotBlank(message = "Campo requerido")
                                    Long sellerId) {
}
