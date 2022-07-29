<template>
  <div
    class="context-menu"
    ref="popper"
    v-show="isVisible"
    tabindex="-1"
    v-click-outside="close"
    @contextmenu.capture.prevent
  >
    <ul>
      <slot :contextData="contextData" />
    </ul>
  </div>
</template>

<script>
import Popper from "popper.js";
import ClickOutside from "vue-click-outside";
export default {
  props: {
    boundariesElement: {
      type: String,
      default: "body",
    },
  },
  data() {
    return {
      opened: false,
      contextData: {},
    };
  },
  directives: {
    ClickOutside,
  },
  computed: {
    isVisible() {
      return this.opened;
    },
  },
  methods: {
    open(evt, contextData) {
      const contextMenus = document.getElementsByClassName("context-menu");
      Array.from(contextMenus).forEach((e) => (e.style.display = "none"));

      this.opened = true;
      this.contextData = contextData;

      if (this.popper) {
        this.popper.destroy();
      }

      this.popper = new Popper(this.referenceObject(evt), this.$refs.popper, {
        placement: "right-start",
        modifiers: {
          preventOverflow: {
            boundariesElement: document.querySelector(this.boundariesElement),
          },
        },
      });
      this.$refs.popper.style.display = "block";
      // Recalculate position
      this.$nextTick(() => {
        this.popper.scheduleUpdate();
      });
    },
    close() {
      this.opened = false;
      this.contextData = null;
    },
    referenceObject(evt) {
      const left = evt.clientX - 230;
      const top = evt.clientY - 64;
      const right = left + 1;
      const bottom = top + 1;
      const clientWidth = 1;
      const clientHeight = 1;

      function getBoundingClientRect() {
        return {
          left,
          top,
          right,
          bottom,
        };
      }

      const obj = {
        getBoundingClientRect,
        clientWidth,
        clientHeight,
      };
      return obj;
    },
  },
  beforeDestroy() {
    if (this.popper !== undefined) {
      this.popper.destroy();
    }
  },
};
</script>

<style lang="scss" scoped>
.context-menu {
  position: fixed;
  z-index: 999;
  overflow: hidden;
  border-radius: 5px;

  &:focus {
    outline: none;
  }

  ul {
    padding: 0px;
    margin: 0px;
  }
}
</style>
