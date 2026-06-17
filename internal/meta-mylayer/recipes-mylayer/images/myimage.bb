SUMMARY = "My Custom Embedded Linux Image"
DESCRIPTION = "A production-ready base image with custom packages."
LICENSE = "CLOSED"

inherit core-image

EXTRA_IMAGE_FEATURES += "ssh-server-openssh debug-tweaks"
IMAGE_INSTALL:append = " \
    sandbox-user \
    myapp-container-installer \
    stress-ng \
    vim \
"
