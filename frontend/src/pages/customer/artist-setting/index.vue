<template>
  <div>
    <user-info />
    <user-service />
    <user-edit-form />
  </div>
</template>
<script>
import UserEditForm from "./components/artist-setting-edit-form.vue";
import UserInfo from "./components/artist-setting-info.vue";
import UserService from "./components/artist-setting-service.vue";
export default {
  name: "Playlist",
  components: {
    UserInfo,
    UserService,
    UserEditForm,
  },
};
</script>
<style lang="scss" scoped></style>
