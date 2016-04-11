DEFAULT_PREFERENCE = "1"

include gstreamer1.0-plugins-bad.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://gst/tta/filters.h;beginline=12;endline=29;md5=8a08270656f2f8ad7bb3655b83138e5a \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 \
                    file://gst/tta/crc32.h;beginline=12;endline=29;md5=27db269c575d1e5317fffca2d33b3b50 \
"

SRCREV = "65770c2af944ba2b222c74bd08dd8a1d01431149"
SRCREV_common = "1b39f6d85a3d51ac6d1b44d8c821fd9b76b34454"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-bad;branch=master;name=base \
           git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

SRC_URI += "file://configure-allow-to-disable-libssh2.patch \
			file://0001-rtmp-fix-seeking-and-potential-segfault.patch \
            file://0001-Makefile.am-don-t-hardcode-libtool-name-when-running.patch \
			file://0004-rtmp-hls-tsdemux-fix.patch \
"

S = "${WORKDIR}/git"
GST_VERSION_FULL ="1.9.0.2"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${SRCPV}"


EXTRA_OECONF += " \
    --disable-openjpeg \
    "

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

