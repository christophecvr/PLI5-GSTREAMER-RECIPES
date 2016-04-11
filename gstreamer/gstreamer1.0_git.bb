DEFAULT_PREFERENCE = "1"

include gstreamer1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d \
                    "
                    
SRCREV = "86c0058ae50ee633beaef4b177ede9529bdb9f16"
SRCREV_common = "1b39f6d85a3d51ac6d1b44d8c821fd9b76b34454"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master;name=base \
		   git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

SRC_URI += "file://0001-revert-use-new-gst-adapter-get-buffer.patch \
			file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
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

