FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://container.cfg"

KERNEL_CONFIG_FRAGMENTS += "container.cfg"