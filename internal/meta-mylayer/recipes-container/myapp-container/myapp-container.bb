SUMMARY = "My application OCI image"

LICENSE = "CLOSED"

inherit image-oci
inherit image

IMAGE_FSTYPES += "container"

IMAGE_CONTAINER_NO_DUMMY = "1"

IMAGE_INSTALL = "\
    busybox \
    lighttpd \
    nginx \
    python3 \
    stress-ng \
"

OCI_IMAGE_TAG = "1.0"
