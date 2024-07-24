package dol.buddy.addicted;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("dol/buddy/addicted/VerifyReturnType.java")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ReturnTypeValidator extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            roundEnv.getElementsAnnotatedWith(annotation).stream()
                    .map(method -> (ExecutableElement) method)
                    .filter(method -> !isStringType(method.getReturnType()))
                    .forEach(method -> processingEnv.getMessager().printMessage(
                            Diagnostic.Kind.ERROR,
                            "Method " + method.getSimpleName() + " should return String",
                            method));
        }
        return true;
    }

    private boolean isStringType(TypeMirror typeMirror) {
        return typeMirror.toString().equals(String.class.getCanonicalName());
    }
}
