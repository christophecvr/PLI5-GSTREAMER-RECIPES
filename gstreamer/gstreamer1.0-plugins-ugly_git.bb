DEFAULT_PREFERENCE = "1"

include gstreamer1.0-plugins-ugly.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://tests/check/elements/xingmux.c;beginline=1;endline=21;md5=4c771b8af188724855cb99cadd390068 \
"

SRCREV = "eacdaa56b3ad388cd28c7ff04ae78aed82c9edd4"
SRCREV_common = "1b39f6d85a3d51ac6d1b44d8c821fd9b76b34454"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-ugly;branch=master;name=base \
		   git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

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

