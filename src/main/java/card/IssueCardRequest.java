package card;

import jakarta.validation.constraints.*;

public record IssueCardRequest(
        @NotBlank @Pattern(regexp = "[0-9]{6}") String productId,
        @NotBlank @Size(max = 120) String holderName
) {
}