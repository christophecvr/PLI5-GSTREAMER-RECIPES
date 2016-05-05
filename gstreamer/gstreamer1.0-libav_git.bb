DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-libav.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                    file://ext/libav/gstav.h;beginline=1;endline=18;md5=a752c35267d8276fd9ca3db6994fca9c \
                    file://gst-libs/ext/libav/LICENSE.md;md5=acda96fe91ccaabc9cd9d541806a0d37 \
                    file://gst-libs/ext/libav/COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://gst-libs/ext/libav/COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504 \
                    file://gst-libs/ext/libav/COPYING.LGPLv2.1;md5=bd7a443320af8c812e4c18d1b79df004 \
                    file://gst-libs/ext/libav/COPYING.LGPLv3;md5=e6a600fd5e1d9cbde2d983680233ad02"

# To build using the system libav/ffmpeg, append "libav" to PACKAGECONFIG
# and remove the ffmpeg sources from SRC_URI below. However, first note the
# warnings in gstreamer1.0-libav.inc
SRC_URI = " \
    git://anongit.freedesktop.org/gstreamer/gst-libav;name=base \
    git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
    git://github.com/FFmpeg/FFmpeg;destsuffix=git/gst-libs/ext/libav;name=ffmpeg;branch=release/3.0 \
    file://0001-Disable-yasm-for-libav-when-disable-yasm.patch \
 "

GST_VERSION_FULL ="1.9.0.1-00"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

SRCREV_base = "438d6b3760683e08addf1d92f07bfa744984b1b6"
SRCREV_common = "ac2f647695e7bd4b433ea108ee1d0e23901797d4"
SRCREV_ffmpeg = "c66f4d1ae64dffaf456d05cbdade02054446f499"
SRCREV_FORMAT = "base"

LIBAV_INCLUDED_EXLUCED = "--disable-everything \
						--enable-decoder=wmalossless --enable-decoder=wmapro --enable-decoder=wmav1 --enable-decoder=wmav2 --enable-decoder=wmavoice"


LIBAV_EXTRA_CONFIGURE_COMMON_ARG = "--target-os=linux \
	--cc='${CC}' --as='${CC}' --ld='${CC}' --nm='${NM}' --ar='${AR}' \
	--ranlib='${RANLIB}' \
	${GSTREAMER_1_0_DEBUG} \
	--disable-mipsdsp \
	--disable-mipsdspr2 \
	${LIBAV_INCLUDED_EXLUCED} \
	--cross-prefix='${HOST_PREFIX}'"

S = "${WORKDIR}/git"

do_configure_prepend() {
	${S}/autogen.sh --noconfigure
}
