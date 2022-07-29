<template>
  <li class="context-menu-item">
    <v-btn class="text-transform-none" text width="100%">
      <slot />
    </v-btn>
  </li>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
.context-menu-item {
    display: block;
    position: relative;
    background: #26272a;
}
.text-transform-none {
    text-transform: unset !important;
}
</style>

