DEFAULT_PREFERENCE = "-1"

include gstreamer1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d \
                    "
                    
SRCREV = "30ee36e6301159b1dd9020c05c64cc0a9aa0355f"
SRCREV_common = "ac2f647695e7bd4b433ea108ee1d0e23901797d4"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master;name=base \
		   git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

SRC_URI += "file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
			file://0001-revert-use-new-gst-adapter-get-buffer.patch"

S = "${WORKDIR}/git"

GST_VERSION_FULL ="1.9.0.1-00"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"


do_configure_prepend() {
	${S}/autogen.sh --noconfigure
}

