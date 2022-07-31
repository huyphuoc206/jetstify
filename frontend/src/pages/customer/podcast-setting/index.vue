<template>
  <div>
    <podcast-setting-info />
    <podcast-setting-service />
    <podcast-setting-edit-form />
  </div>
</template>
<script>
import PodcastSettingEditForm from "./components/podcast-setting-edit-form.vue";
import PodcastSettingInfo from "./components/podcast-setting-info.vue";
import PodcastSettingService from "./components/podcast-setting-service.vue";
export default {
  name: "PodcastSettings",
  components: {
    PodcastSettingEditForm,
    PodcastSettingInfo,
    PodcastSettingService,
  },
};
</script>
