<template>
  <div>
    <user-info/>
    <user-service />
    <user-edit-form />
  </div>
</template>
<script>
import UserEditForm from './components/user-edit-form.vue';
import UserInfo from './components/user-info.vue';
import UserService from "./components/user-service.vue";
export default {
  name: "Playlist",
  components: {
    UserInfo,
    UserService,
    UserEditForm,
  },
};
</script>
<style lang="scss" scoped>

</style>
