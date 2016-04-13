DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-libav.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                    file://ext/libav/gstav.h;beginline=1;endline=18;md5=a752c35267d8276fd9ca3db6994fca9c"

SRCREV = "1af733a6366d0f148874bd10958a38ceb79b9be4"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-libav;branch=master"

S = "${WORKDIR}/git"

GST_VERSION_FULL = "1.9.0.1"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

LIBAV_INCLUDED_EXLUCED = "--disable-everything \
						--enable-decoder=wmalossless --enable-decoder=wmapro --enable-decoder=wmav1 --enable-decoder=wmav2 --enable-decoder=wmavoice"

LIBAV_EXTRA_CONFIGURE_COMMON_ARG = "--target-os=linux \
  --cc='${CC}' --as='${CC}' --ld='${CC}' --nm='${NM}' --ar='${AR}' \
  ${GSTREAMER_1_0_DEBUG} \
  --disable-mipsdsp \
  --disable-mipsdspr2 \
  ${LIBAV_INCLUDED_EXLUCED} \
  --cross-prefix='${HOST_PREFIX}'"


do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

