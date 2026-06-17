FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://firejail-bash"

RDEPENDS:${PN}:append = " \
    bash \
    firejail \
"

do_install:append() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${WORKDIR}/firejail-bash \
        ${D}/usr/local/bin/firejail-bash

    install -d ${D}/root
    install -d ${D}${sysconfdir}
    if [ -f ${D}${sysconfdir}/shells ]; then
        grep -qxF "/usr/local/bin/firejail-bash" ${D}${sysconfdir}/shells || \
            echo "/usr/local/bin/firejail-bash" >> ${D}${sysconfdir}/shells
    else
        echo "/usr/local/bin/firejail-bash" > ${D}${sysconfdir}/shells
    fi
}

FILES:${PN}:append = " \
    /root \
    /usr/local/bin/firejail-bash \
    "