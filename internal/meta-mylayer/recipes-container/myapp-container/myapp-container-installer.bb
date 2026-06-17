SUMMARY = "Install MyApp OCI image"

LICENSE = "CLOSED"

DEPENDS += "myapp-container"

SRC_URI = ""

do_install() {
    install -d ${D}/usr/share/containers

    install -m 0644 \
        ${DEPLOY_DIR_IMAGE}/myapp-container-${MACHINE}.rootfs.tar.bz2 \
        ${D}/usr/share/containers/
}

FILES:${PN} += "/usr/share/containers/"

do_install[depends] += "myapp-container:do_image_complete"

RDEPENDS:${PN} += " \
    podman \
"
