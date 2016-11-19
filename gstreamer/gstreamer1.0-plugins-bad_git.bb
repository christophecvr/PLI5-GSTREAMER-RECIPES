DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-plugins-bad.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://gst/tta/filters.h;beginline=12;endline=29;md5=8a08270656f2f8ad7bb3655b83138e5a \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 \
                    file://gst/tta/crc32.h;beginline=12;endline=29;md5=27db269c575d1e5317fffca2d33b3b50 \
"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

SRCREV_base = "0f657cec07665512c9447b018d5c0167242b6388"
SRCREV_common = "d01567411258358ddc6f632bf0ed2363a36ca795"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-bad;branch=master;name=base \
           git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"


SRC_URI += "file://configure-allow-to-disable-libssh2.patch \
			file://0001-Makefile.am-don-t-hardcode-libtool-name-when-running-pbad.patch \
			file://0001-rtmp-fix-seeking-and-potential-segfault.patch \
			file://0004-rtmp-hls-tsdemux-fix.patch \
			file://fix-maybe-uninitialized-warnings-when-compiling-with-Os.patch \
			file://hls-use-max-playlist-quality.patch \
"
S = "${WORKDIR}/git"

GST_VERSION_FULL ="1.11.0.1-01"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"


EXTRA_OECONF += " \
    --disable-openjpeg \
    "

do_configure_prepend() {
	${S}/autogen.sh --noconfigure
}

