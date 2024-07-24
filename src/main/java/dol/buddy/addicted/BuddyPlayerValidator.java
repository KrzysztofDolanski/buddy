package dol.buddy.addicted;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BuddyPlayerValidator implements ConstraintValidator<Verify, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
