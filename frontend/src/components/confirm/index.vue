<template>
  <v-dialog v-model="showDialog" :max-width="widthDialog" @keydown.esc="cancel">
    <v-card>
      <v-toolbar dark color="primary" dense flat>
        <v-toolbar-title class="white--text">{{ title }}</v-toolbar-title>
      </v-toolbar>
      <v-card-text v-show="!!message" class="pt-4">
        <h3>{{ message }}</h3>
      </v-card-text>
      <v-card-actions class="pt-0">
        <v-spacer></v-spacer>
        <v-btn color="primary darken-1" text @click.native="handleAgree">Yes</v-btn>
        <v-btn color="grey" text @click.native="handleCancel">Cancel</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    show: {
      type:    Boolean,
      default: true
    },
    title: {
      type:    String,
      default: 'Confirmation'
    },
    message: {
      type:    String,
      default: 'Are you sure?'
    },
    widthDialog: {
      type:    String,
      default: '700'
    },
    agree: {
      type: Function,
      default: () => {}
    },
    cancel: {
      type: Function,
      default: () => {}
    }
  },

  data: () => ({
    showDialog: false,
  }),

  created() {
    this.showDialog = this.show;
  },

  methods: {
    handleAgree() {
      this.agree();
      this.showDialog = false
    },
    handleCancel() {
      this.cancel();
      this.showDialog = false
    }
  }
}
</script>