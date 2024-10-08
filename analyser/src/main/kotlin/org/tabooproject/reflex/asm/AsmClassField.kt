package org.tabooproject.reflex.asm

import org.tabooproject.reflex.*
import java.lang.reflect.Modifier

/**
 * @author 坏黑
 * @since 2022/1/21 6:33 PM
 */
@Internal
class AsmClassField(
    name: String,
    owner: LazyClass,
    val descriptor: String,
    val access: Int,
    val classFinder: ClassAnalyser.ClassFinder,
    override val annotations: List<ClassAnnotation>
) : JavaClassField(name, owner) {

    override val type = AsmSignature.signatureToClass(descriptor, classFinder).first()

    override val isStatic: Boolean
        get() = Modifier.isStatic(access)

    override val isTransient: Boolean
        get() = Modifier.isTransient(access)

    override val isFinal: Boolean
        get() = Modifier.isFinal(access)

    override val isPublic: Boolean
        get() = Modifier.isPublic(access)

    override val isProtected: Boolean
        get() = Modifier.isProtected(access)

    override val isPrivate: Boolean
        get() = Modifier.isPrivate(access)

    override fun toString(): String {
        return "AsmClassField(descriptor='$descriptor', access=$access) ${super.toString()}"
    }
}