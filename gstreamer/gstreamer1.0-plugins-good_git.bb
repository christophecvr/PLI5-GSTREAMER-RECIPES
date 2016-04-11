DEFAULT_PREFERENCE = "1"

include gstreamer1.0-plugins-good.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe \
"

SRCREV = "95dc198563c88b59c27dc842eb95030d8a07e6dc"
SRCREV_common = "1b39f6d85a3d51ac6d1b44d8c821fd9b76b34454"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-good;branch=master;name=base \
           git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

SRC_URI += "file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

S = "${WORKDIR}/git"

GST_VERSION_FULL ="1.9.0.2"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${SRCPV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

