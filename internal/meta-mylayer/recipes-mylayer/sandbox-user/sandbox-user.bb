SUMMARY = "Sandbox user configuration"
LICENSE = "CLOSED"

inherit useradd extrausers

SRC_URI = "\
    file://sandbox-sudo \
    file://sandbox-sshd.conf \
"

RDEPENDS:${PN} += "\
    sudo \
    openssh \
    base-files \
"

do_install() {
    install -d ${D}${sysconfdir}/sudoers.d
    install -m 0440 ${WORKDIR}/sandbox-sudo \
        ${D}${sysconfdir}/sudoers.d/sandbox

    install -d ${D}${sysconfdir}/ssh/sshd_config.d
    install -m 0644 ${WORKDIR}/sandbox-sshd.conf \
        ${D}${sysconfdir}/ssh/sshd_config.d/

}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-u 1200 -d /home/sandbox -m -s /usr/local/bin/firejail-bash sandbox"

EXTRA_USERS_PARAMS += "\
    passwd -d sandbox; \
"

FILES:${PN} += "\
    ${sysconfdir}/sudoers.d/sandbox \
    ${sysconfdir}/ssh/sshd_config.d/sandbox-sshd.conf \
"
