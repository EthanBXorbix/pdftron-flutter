package com.pdftron.pdftronflutter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.pdftron.common.PDFNetException;
import com.pdftron.fdf.FDFDoc;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.pdf.PDFViewCtrl;
import com.pdftron.pdf.Rect;
import com.pdftron.pdf.ViewChangeCollection;
import com.pdftron.pdf.config.ViewerConfig;
import com.pdftron.pdf.controls.PdfViewCtrlTabFragment;
import com.pdftron.pdf.tools.Tool;
import com.pdftron.pdf.controls.PdfViewCtrlTabHostFragment;
import com.pdftron.pdf.tools.AdvancedShapeCreate;
import com.pdftron.pdf.tools.FreehandCreate;
import com.pdftron.pdf.tools.ToolManager;
import com.pdftron.pdf.utils.BookmarkManager;
import com.pdftron.pdf.utils.PdfViewCtrlSettingsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class PluginUtils {


    public static final String KEY_LICENSE_KEY = "licenseKey";
    public static final String KEY_DOCUMENT = "document";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_CONFIG = "config";
    public static final String KEY_XFDF_COMMAND = "xfdfCommand";
    public static final String KEY_BOOKMARK_JSON = "bookmarkJson";
    public static final String KEY_PAGE_NUMBER = "pageNumber";
    public static final String KEY_TOOL_MODE = "toolMode";
    public static final String KEY_FIELD_NAMES = "fieldNames";
    public static final String KEY_FLAG = "flag";
    public static final String KEY_FLAG_VALUE = "flagValue";
    public static final String KEY_FIELDS = "fields";

    public static final String KEY_CONFIG_DISABLED_ELEMENTS = "disabledElements";
    public static final String KEY_CONFIG_DISABLED_TOOLS = "disabledTools";
    public static final String KEY_CONFIG_MULTI_TAB_ENABLED = "multiTabEnabled";
    public static final String KEY_CONFIG_CUSTOM_HEADERS = "customHeaders";

    private static final String KEY_X1 = "x1";
    private static final String KEY_Y1 = "y1";
    private static final String KEY_X2 = "x2";
    private static final String KEY_Y2 = "y2";
    private static final String KEY_WIDTH = "width";
    private static final String KEY_HEIGHT = "height";

    private static final String KEY_FIELD_NAME = "fieldName";
    private static final String KEY_FIELD_VALUE = "fieldValue";

    public static final String EVENT_EXPORT_ANNOTATION_COMMAND = "export_annotation_command_event";
    public static final String EVENT_EXPORT_BOOKMARK = "export_bookmark_event";
    public static final String EVENT_DOCUMENT_LOADED = "document_loaded_event";

    public static final String FUNCTION_GET_PLATFORM_VERSION = "getPlatformVersion";
    public static final String FUNCTION_GET_VERSION = "getVersion";
    public static final String FUNCTION_INITALIZE = "initialize";
    public static final String FUNCTION_OPEN_DOCUMENT = "openDocument";
    public static final String FUNCTION_IMPORT_ANNOTATION_COMMAND = "importAnnotationCommand";
    public static final String FUNCTION_IMPORT_BOOKMARK_JSON = "importBookmarkJson";
    public static final String FUNCTION_SAVE_DOCUMENT = "saveDocument";
    public static final String FUNCTION_COMMIT_TOOL = "commitTool";
    public static final String FUNCTION_GET_PAGE_COUNT = "getPageCount";
    public static final String FUNCTION_HANDLE_BACK_BUTTON = "handleBackButton";
    public static final String FUNCTION_GET_PAGE_CROP_BOX = "getPageCropBox";
    public static final String FUNCTION_SET_TOOL_MODE = "setToolMode";
    public static final String FUNCTION_SET_FLAG_FOR_FIELDS = "setFlagForFields";
    public static final String FUNCTION_SET_VALUES_FOR_FIELDS = "setValuesForFields";

    private static final String BUTTON_TOOLS = "toolsButton";
    private static final String BUTTON_SEARCH = "searchButton";
    private static final String BUTTON_SHARE = "shareButton";
    private static final String BUTTON_VIEW_CONTROLS = "viewControlsButton";
    private static final String BUTTON_THUMBNAILS = "thumbnailsButton";
    private static final String BUTTON_LISTS = "listsButton";
    private static final String BUTTON_THUMBNAIL_SLIDER = "thumbnailSlider";
    private static final String BUTTON_SAVE_COPY = "saveCopyButton";
    private static final String BUTTON_EDIT_PAGES = "editPagesButton";
    private static final String BUTTON_PRINT = "printButton";
    private static final String BUTTON_FILL_AND_SIGN = "fillAndSignButton";
    private static final String BUTTON_PREPARE_FORM = "prepareFormButton";
    private static final String BUTTON_REFLOW_MODE = "reflowModeButton";

    private static final String TOOL_BUTTON_FREE_HAND = "freeHandToolButton";
    private static final String TOOL_BUTTON_HIGHTLIGHT = "hightlightToolButton";
    private static final String TOOL_BUTTON_UNDERLINE = "underlineToolButton";
    private static final String TOOL_BUTTON_SQUIGGLY = "squigglyToolButton";
    private static final String TOOL_BUTTON_STRIKEOUT = "strikeoutToolButton";
    private static final String TOOL_BUTTON_RECTANGLE = "rectangleToolButton";
    private static final String TOOL_BUTTON_ELLIPSE = "ellipseToolButton";
    private static final String TOOL_BUTTON_LINE = "lineToolButton";
    private static final String TOOL_BUTTON_ARROW = "arrowToolButton";
    private static final String TOOL_BUTTON_POLYLINE = "polylineToolButton";
    private static final String TOOL_BUTTON_POLYGON = "polygonToolButton";
    private static final String TOOL_BUTTON_CLOUD = "cloudToolButton";
    private static final String TOOL_BUTTON_SIGNATURE = "signatureToolButton";
    private static final String TOOL_BUTTON_FREE_TEXT = "freeTextToolButton";
    private static final String TOOL_BUTTON_STICKY = "stickyToolButton";
    private static final String TOOL_BUTTON_CALLOUT = "calloutToolButton";
    private static final String TOOL_BUTTON_STAMP = "stampToolButton";

    private static final String TOOL_ANNOTATION_CREATE_FREE_HAND = "AnnotationCreateFreeHand";
    private static final String TOOL_ANNOTATION_CREATE_TEXT_HIGHLIGHT = "AnnotationCreateTextHighlight";
    private static final String TOOL_ANNOTATION_CREATE_TEXT_UNDERLINE = "AnnotationCreateTextUnderline";
    private static final String TOOL_ANNOTATION_CREATE_TEXT_SQUIGGLY = "AnnotationCreateTextSquiggly";
    private static final String TOOL_ANNOTATION_CREATE_TEXT_STRIKEOUT = "AnnotationCreateTextStrikeout";
    private static final String TOOL_ANNOTATION_CREATE_RECTANGLE = "AnnotationCreateRectangle";
    private static final String TOOL_ANNOTATION_CREATE_ELLIPSE = "AnnotationCreateEllipse";
    private static final String TOOL_ANNOTATION_CREATE_LINE = "AnnotationCreateLine";
    private static final String TOOL_ANNOTATION_CREATE_ARROW = "AnnotationCreateArrow";
    private static final String TOOL_ANNOTATION_CREATE_POLYLINE = "AnnotationCreatePolyline";
    private static final String TOOL_ANNOTATION_CREATE_POLYGON = "AnnotationCreatePolygon";
    private static final String TOOL_ANNOTATION_CREATE_POLYGON_CLOUD = "AnnotationCreatePolygonCloud";
    private static final String TOOL_ANNOTATION_CREATE_SIGNATURE = "AnnotationCreateSignature";
    private static final String TOOL_ANNOTATION_CREATE_FREE_TEXT = "AnnotationCreateFreeText";
    private static final String TOOL_ANNOTATION_CREATE_STICKY = "AnnotationCreateSticky";
    private static final String TOOL_ANNOTATION_CREATE_CALLOUT = "AnnotationCreateCallout";
    private static final String TOOL_ANNOTATION_CREATE_STAMP = "AnnotationCreateStamp";
    private static final String TOOL_ANNOTATION_CREATE_DISTANCE_MEASUREMENT = "AnnotationCreateDistanceMeasurement";
    private static final String TOOL_ANNOTATION_CREATE_PERIMETER_MEASUREMENT = "AnnotationCreatePerimeterMeasurement";
    private static final String TOOL_ANNOTATION_CREATE_AREA_MEASUREMENT = "AnnotationCreateAreaMeasurement";
    private static final String TOOL_TEXT_SELECT = "TextSelect";
    private static final String TOOL_ANNOTATION_EDIT = "AnnotationEdit";
    private static final String TOOL_ANNOTATION_CREATE_SOUND = "AnnotationCreateSound";
    private static final String TOOL_ANNOTATION_CREATE_FREE_HIGHLIGHTER = "AnnotationCreateFreeHighlighter";
    private static final String TOOL_ANNOTATION_CREATE_RUBBER_STAMP = "AnnotationCreateRubberStamp";
    private static final String TOOL_ERASER = "Eraser";

    public static ArrayList<ToolManager.ToolMode> disableElements(ViewerConfig.Builder builder, JSONArray args) throws JSONException {
        for (int i = 0; i < args.length(); i++) {
            String item = args.getString(i);
            if (BUTTON_TOOLS.equals(item)) {
                builder = builder.showAnnotationToolbarOption(false);
            } else if (BUTTON_SEARCH.equals(item)) {
                builder = builder.showSearchView(false);
            } else if (BUTTON_SHARE.equals(item)) {
                builder = builder.showShareOption(false);
            } else if (BUTTON_VIEW_CONTROLS.equals(item)) {
                builder = builder.showDocumentSettingsOption(false);
            } else if (BUTTON_THUMBNAILS.equals(item)) {
                builder = builder.showThumbnailView(false);
            } else if (BUTTON_LISTS.equals(item)) {
                builder = builder
                        .showAnnotationsList(false)
                        .showOutlineList(false)
                        .showUserBookmarksList(false);
            } else if (BUTTON_THUMBNAIL_SLIDER.equals(item)) {
                builder = builder.showBottomNavBar(false);
            } else if (BUTTON_SAVE_COPY.equals(item)) {
                builder = builder.showSaveCopyOption(false);
            } else if (BUTTON_EDIT_PAGES.equals(item)) {
                builder = builder.showEditPagesOption(false);
            } else if (BUTTON_PRINT.equals(item)) {
                builder = builder.showPrintOption(false);
            } else if (BUTTON_FILL_AND_SIGN.equals(item)) {
                builder = builder.showFillAndSignToolbarOption(false);
            } else if (BUTTON_PREPARE_FORM.equals(item)) {
                builder = builder.showFormToolbarOption(false);
            } else if (BUTTON_REFLOW_MODE.equals(item)) {
                builder = builder.showReflowOption(false);
            }
        }
        return disableTools(args);
    }

    public static ArrayList<ToolManager.ToolMode> disableTools(JSONArray args) throws JSONException {
        ArrayList<ToolManager.ToolMode> tools = new ArrayList<>();
        for (int i = 0; i < args.length(); i++) {
            String item = args.getString(i);
            ToolManager.ToolMode mode = convStringToToolMode(item);
            if (mode != null) {
                tools.add(mode);
            }
        }
        return tools;
    }

    public static ToolManager.ToolMode convStringToToolMode(String item) {
        ToolManager.ToolMode mode = null;
        if (TOOL_BUTTON_FREE_HAND.equals(item) || TOOL_ANNOTATION_CREATE_FREE_HAND.equals(item)) {
            mode = ToolManager.ToolMode.INK_CREATE;
        } else if (TOOL_BUTTON_HIGHTLIGHT.equals(item) || TOOL_ANNOTATION_CREATE_TEXT_HIGHLIGHT.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_HIGHLIGHT;
        } else if (TOOL_BUTTON_UNDERLINE.equals(item) || TOOL_ANNOTATION_CREATE_TEXT_UNDERLINE.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_UNDERLINE;
        } else if (TOOL_BUTTON_SQUIGGLY.equals(item) || TOOL_ANNOTATION_CREATE_TEXT_SQUIGGLY.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_SQUIGGLY;
        } else if (TOOL_BUTTON_STRIKEOUT.equals(item) || TOOL_ANNOTATION_CREATE_TEXT_STRIKEOUT.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_STRIKEOUT;
        } else if (TOOL_BUTTON_RECTANGLE.equals(item) || TOOL_ANNOTATION_CREATE_RECTANGLE.equals(item)) {
            mode = ToolManager.ToolMode.RECT_CREATE;
        } else if (TOOL_BUTTON_ELLIPSE.equals(item) || TOOL_ANNOTATION_CREATE_ELLIPSE.equals(item)) {
            mode = ToolManager.ToolMode.OVAL_CREATE;
        } else if (TOOL_BUTTON_LINE.equals(item) || TOOL_ANNOTATION_CREATE_LINE.equals(item)) {
            mode = ToolManager.ToolMode.LINE_CREATE;
        } else if (TOOL_BUTTON_ARROW.equals(item) || TOOL_ANNOTATION_CREATE_ARROW.equals(item)) {
            mode = ToolManager.ToolMode.ARROW_CREATE;
        } else if (TOOL_BUTTON_POLYLINE.equals(item) || TOOL_ANNOTATION_CREATE_POLYLINE.equals(item)) {
            mode = ToolManager.ToolMode.POLYLINE_CREATE;
        } else if (TOOL_BUTTON_POLYGON.equals(item) || TOOL_ANNOTATION_CREATE_POLYGON.equals(item)) {
            mode = ToolManager.ToolMode.POLYGON_CREATE;
        } else if (TOOL_BUTTON_CLOUD.equals(item) || TOOL_ANNOTATION_CREATE_POLYGON_CLOUD.equals(item)) {
            mode = ToolManager.ToolMode.CLOUD_CREATE;
        } else if (TOOL_BUTTON_SIGNATURE.equals(item) || TOOL_ANNOTATION_CREATE_SIGNATURE.equals(item)) {
            mode = ToolManager.ToolMode.SIGNATURE;
        } else if (TOOL_BUTTON_FREE_TEXT.equals(item) || TOOL_ANNOTATION_CREATE_FREE_TEXT.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_CREATE;
        } else if (TOOL_BUTTON_STICKY.equals(item) || TOOL_ANNOTATION_CREATE_STICKY.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_ANNOT_CREATE;
        } else if (TOOL_BUTTON_CALLOUT.equals(item) || TOOL_ANNOTATION_CREATE_CALLOUT.equals(item)) {
            mode = ToolManager.ToolMode.CALLOUT_CREATE;
        } else if (TOOL_BUTTON_STAMP.equals(item) || TOOL_ANNOTATION_CREATE_STAMP.equals(item)) {
            mode = ToolManager.ToolMode.STAMPER;
        } else if (TOOL_ANNOTATION_CREATE_DISTANCE_MEASUREMENT.equals(item)) {
            mode = ToolManager.ToolMode.RULER_CREATE;
        } else if (TOOL_ANNOTATION_CREATE_PERIMETER_MEASUREMENT.equals(item)) {
            mode = ToolManager.ToolMode.PERIMETER_MEASURE_CREATE;
        } else if (TOOL_ANNOTATION_CREATE_AREA_MEASUREMENT.equals(item)) {
            mode = ToolManager.ToolMode.AREA_MEASURE_CREATE;
        } else if (TOOL_TEXT_SELECT.equals(item)) {
            mode = ToolManager.ToolMode.TEXT_SELECT;
        } else if (TOOL_ANNOTATION_EDIT.equals(item)) {
            mode = ToolManager.ToolMode.ANNOT_EDIT_RECT_GROUP;
        } else if (TOOL_ANNOTATION_CREATE_SOUND.equals(item)) {
            mode = ToolManager.ToolMode.SOUND_CREATE;
        } else if (TOOL_ANNOTATION_CREATE_FREE_HIGHLIGHTER.equals(item)) {
            mode = ToolManager.ToolMode.FREE_HIGHLIGHTER;
        } else if (TOOL_ANNOTATION_CREATE_RUBBER_STAMP.equals(item)) {
            mode = ToolManager.ToolMode.RUBBER_STAMPER;
        } else if (TOOL_ERASER.equals(item)) {
            mode = ToolManager.ToolMode.INK_ERASER;
        }
        return mode;
    }

    public static void onMethodCall(MethodCall call, MethodChannel.Result result, ViewActivityComponent component) {
        switch (call.method) {
            case FUNCTION_IMPORT_ANNOTATION_COMMAND: {
                checkFunctionPrecondition(component);
                String xfdfCommand = call.argument(KEY_XFDF_COMMAND);
                try {
                    importAnnotationCommand(xfdfCommand, result, component);
                } catch (PDFNetException ex) {
                    ex.printStackTrace();
                    result.error(Long.toString(ex.getErrorCode()), "PDFTronException Error: " + ex, null);
                }
                break;
            }
            case FUNCTION_IMPORT_BOOKMARK_JSON: {
                checkFunctionPrecondition(component);
                String bookmarkJson = call.argument(KEY_BOOKMARK_JSON);
                try {
                    importBookmarkJson(bookmarkJson, result, component);
                } catch (JSONException ex) {
                    ex.printStackTrace();
                    result.error(Integer.toString(ex.hashCode()), "JSONException Error: " + ex, null);
                }
                break;
            }
            case FUNCTION_SAVE_DOCUMENT: {
                checkFunctionPrecondition(component);
                saveDocument(result, component);
                break;
            }
            case FUNCTION_COMMIT_TOOL: {
                checkFunctionPrecondition(component);
                commitTool(result, component);
                break;
            }
            case FUNCTION_GET_PAGE_COUNT: {
                checkFunctionPrecondition(component);
                try {
                    getPageCount(result, component);
                } catch (PDFNetException ex) {
                    ex.printStackTrace();
                    result.error(Long.toString(ex.getErrorCode()), "PDFTronException Error: " + ex, null);
                }
                break;
            }
            case FUNCTION_HANDLE_BACK_BUTTON: {
                checkFunctionPrecondition(component);
                handleBackButton(result, component);
                break;
            }
            case FUNCTION_GET_PAGE_CROP_BOX: {
                checkFunctionPrecondition(component);
                Integer pageNumber = call.argument(KEY_PAGE_NUMBER);
                if (pageNumber != null) {
                    try {
                        getPageCropBox(pageNumber, result, component);
                    } catch (JSONException ex) {
                        ex.printStackTrace();
                        result.error(Integer.toString(ex.hashCode()), "JSONException Error: " + ex, null);
                    } catch (PDFNetException ex) {
                        ex.printStackTrace();
                        result.error(Long.toString(ex.getErrorCode()), "PDFTronException Error: " + ex, null);
                    }
                }
                break;
            }
            case FUNCTION_SET_TOOL_MODE: {
                checkFunctionPrecondition(component);
                String toolModeString = call.argument(KEY_TOOL_MODE);
                setToolMode(toolModeString, result, component);
                break;
            }
            case FUNCTION_SET_FLAG_FOR_FIELDS: {
                checkFunctionPrecondition(component);
                ArrayList<String> fieldNames = call.argument(KEY_FIELD_NAMES);
                Integer flag = call.argument(KEY_FLAG);
                Boolean flagValue = call.argument(KEY_FLAG_VALUE);
                if (fieldNames != null && flag != null && flagValue != null) {
                    try {
                        setFlagForFields(fieldNames, flag, flagValue, result, component);
                    } catch (PDFNetException ex) {
                        ex.printStackTrace();
                        result.error(Long.toString(ex.getErrorCode()), "PDFTronException Error: " + ex, null);
                    }
                }
                break;
            }
            case FUNCTION_SET_VALUES_FOR_FIELDS: {
                checkFunctionPrecondition(component);
                String fieldsString = call.argument(KEY_FIELDS);
                if (fieldsString != null) {
                    try {
                        setValuesForFields(fieldsString, result, component);
                    } catch (JSONException ex) {
                        ex.printStackTrace();
                        result.error(Integer.toString(ex.hashCode()), "JSONException Error: " + ex, null);
                    } catch (PDFNetException ex) {
                        ex.printStackTrace();
                        result.error(Long.toString(ex.getErrorCode()), "PDFTronException Error: " + ex, null);
                    }
                }
                break;
            }
            default:
                result.notImplemented();
                break;
        }
    }

    // Methods

    private static void importAnnotationCommand(String xfdfCommand, MethodChannel.Result result, ViewActivityComponent component) throws PDFNetException {
        PDFViewCtrl pdfViewCtrl = component.getPdfViewCtrl();
        PDFDoc pdfDoc = component.getPdfDoc();
        if (null == pdfViewCtrl || null == pdfDoc || null == xfdfCommand) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }
        boolean shouldUnlockRead = false;
        try {
            pdfViewCtrl.docLockRead();
            shouldUnlockRead = true;

            if (pdfDoc.hasDownloader()) {
                // still downloading file, let's wait for next call
                result.error("InvalidState", "Document download in progress, try again later", null);
                return;
            }
        } finally {
            if (shouldUnlockRead) {
                pdfViewCtrl.docUnlockRead();
            }
        }

        boolean shouldUnlock = false;
        try {
            pdfViewCtrl.docLock(true);
            shouldUnlock = true;

            FDFDoc fdfDoc = pdfDoc.fdfExtract(PDFDoc.e_both);
            fdfDoc.mergeAnnots(xfdfCommand);

            pdfDoc.fdfUpdate(fdfDoc);
            pdfViewCtrl.update(true);
            result.success(null);
        } finally {
            if (shouldUnlock) {
                pdfViewCtrl.docUnlock();
            }
        }
    }

    private static void importBookmarkJson(String bookmarkJson, MethodChannel.Result result, ViewActivityComponent component) throws JSONException {
        PDFViewCtrl pdfViewCtrl = component.getPdfViewCtrl();
        if (null == pdfViewCtrl || null == bookmarkJson) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }
        BookmarkManager.importPdfBookmarks(pdfViewCtrl, bookmarkJson);
        result.success(null);
    }

    private static void saveDocument(MethodChannel.Result result, ViewActivityComponent component) {
        PdfViewCtrlTabFragment pdfViewCtrlTabFragment = component.getPdfViewCtrlTabFragment();
        if (pdfViewCtrlTabFragment != null) {
            pdfViewCtrlTabFragment.setSavingEnabled(true);
            pdfViewCtrlTabFragment.save(false, true, true);
            // TODO if add auto save flag: getPdfViewCtrlTabFragment().setSavingEnabled(mAutoSaveEnabled);
            result.success(pdfViewCtrlTabFragment.getFilePath());
            return;
        }
        result.error("InvalidState", "Activity not attached", null);
    }

    private static void commitTool(MethodChannel.Result result, ViewActivityComponent component) {
        ToolManager toolManager = component.getToolManager();
        if (toolManager != null) {
            ToolManager.Tool currentTool = toolManager.getTool();
            if (currentTool instanceof FreehandCreate) {
                ((FreehandCreate) currentTool).commitAnnotation();
                toolManager.setTool(toolManager.createTool(ToolManager.ToolMode.PAN, null));
                result.success(true);
            } else if (currentTool instanceof AdvancedShapeCreate) {
                ((AdvancedShapeCreate) currentTool).commit();
                toolManager.setTool(toolManager.createTool(ToolManager.ToolMode.PAN, null));
                result.success(true);
            }
            result.success(false);
            return;
        }
        result.error("InvalidState", "Tool manager not found", null);
    }

    private static void getPageCount(MethodChannel.Result result, ViewActivityComponent component) throws PDFNetException {
        PDFDoc pdfDoc = component.getPdfDoc();
        if (pdfDoc == null) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }
        result.success(pdfDoc.getPageCount());
    }

    private static void handleBackButton(MethodChannel.Result result, ViewActivityComponent component) {
        PdfViewCtrlTabHostFragment pdfViewCtrlTabHostFragment = component.getPdfViewCtrlTabHostFragment();
        if (pdfViewCtrlTabHostFragment == null) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }

        result.success(pdfViewCtrlTabHostFragment.handleBackPressed());
    }

    private static void getPageCropBox(int pageNumber, MethodChannel.Result result, ViewActivityComponent component) throws PDFNetException, JSONException {
        JSONObject jsonObject = new JSONObject();
        PDFDoc pdfDoc = component.getPdfDoc();
        if (pdfDoc == null) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }

        Rect rect = pdfDoc.getPage(pageNumber).getCropBox();
        jsonObject.put(KEY_X1, rect.getX1());
        jsonObject.put(KEY_Y1, rect.getY1());
        jsonObject.put(KEY_X2, rect.getX2());
        jsonObject.put(KEY_Y2, rect.getY2());
        jsonObject.put(KEY_WIDTH, rect.getWidth());
        jsonObject.put(KEY_HEIGHT, rect.getHeight());
        result.success(jsonObject.toString());
    }

    private static void setFlagForFields(ArrayList<String> fieldNames, int flag, boolean flagValue, MethodChannel.Result result, ViewActivityComponent component) throws PDFNetException {
        PDFViewCtrl pdfViewCtrl = component.getPdfViewCtrl();
        PDFDoc pdfdoc = component.getPdfDoc();
        if (null == pdfViewCtrl || null == pdfdoc) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }

        boolean shouldUnlock = false;
        try {
            pdfViewCtrl.docLock(true);
            shouldUnlock = true;

            for (String fieldName : fieldNames) {
                Field field = pdfdoc.getField(fieldName);
                if (field != null && field.isValid()) {
                    field.setFlag(flag, flagValue);
                    pdfViewCtrl.update(field);
                }
            }
        } finally {
            if (shouldUnlock) {
                pdfViewCtrl.docUnlock();
            }
        }
        result.success(null);
    }

    private static void setValuesForFields(String fieldsString, MethodChannel.Result result, ViewActivityComponent component) throws PDFNetException, JSONException {
        PDFViewCtrl pdfViewCtrl = component.getPdfViewCtrl();
        PDFDoc pdfDoc = component.getPdfDoc();
        if (null == pdfViewCtrl || null == pdfDoc) {
            result.error("InvalidState", "Activity not attached", null);
            return;
        }

        JSONArray fieldsArray = new JSONArray(fieldsString);

        boolean shouldUnlock = false;
        try {
            pdfViewCtrl.docLock(true);
            shouldUnlock = true;

            for (int i = 0; i < fieldsArray.length(); i ++) {
                JSONObject fieldObject = fieldsArray.getJSONObject(i);

                String fieldName = fieldObject.getString(KEY_FIELD_NAME);

                Field field = pdfDoc.getField(fieldName);
                if (field != null && field.isValid()) {
                    setFieldValue(pdfViewCtrl, field, fieldObject.get(KEY_FIELD_VALUE));
                }
            }

        } finally {
            if (shouldUnlock) {
                pdfViewCtrl.docUnlock();
            }
        }
        result.success(null);
    }

    // write lock required around this method
    private static void setFieldValue(PDFViewCtrl pdfViewCtrl, Field field, Object value) throws PDFNetException, JSONException {
        int fieldType = field.getType();

        if (value instanceof Boolean) {
            if (Field.e_check == fieldType) {
                ViewChangeCollection view_change = field.setValue((boolean)value);
                pdfViewCtrl.refreshAndUpdate(view_change);
            }
        }
        else if (value instanceof String) {
            if (Field.e_text == fieldType || Field.e_radio == fieldType || Field.e_choice == fieldType) {
                ViewChangeCollection view_change = field.setValue((String)value);
                pdfViewCtrl.refreshAndUpdate(view_change);
            }
        } else if (value instanceof Integer || value instanceof Double || value instanceof Long || value instanceof Float) {
            if (Field.e_text == fieldType) {
                ViewChangeCollection view_change = field.setValue(String.valueOf(value));
                pdfViewCtrl.refreshAndUpdate(view_change);
            }
        }
    }

    private static void setToolMode(String toolModeString, MethodChannel.Result result, ViewActivityComponent component) {
        ToolManager toolManager = component.getToolManager();
        Context context = component.getPdfViewCtrl() != null ? component.getPdfViewCtrl().getContext() : null;
        if (toolManager == null || context == null) {
            result.error("InvalidState", "PDFViewCtrl not found", null);
            return;
        }

        ToolManager.ToolMode mode = convStringToToolMode(toolModeString);
        Tool tool = (Tool) toolManager.createTool(mode, null);
        boolean continuousAnnot = PdfViewCtrlSettingsManager.getContinuousAnnotationEdit(context);
        tool.setForceSameNextToolMode(continuousAnnot);
        toolManager.setTool(tool);
        result.success(null);
    }

    // Events

    public static void handleAnnotationModifications(final ViewActivityComponent component) {
        ToolManager toolManager = component.getToolManager();
        if (toolManager != null) {
            toolManager.addAnnotationModificationListener(new ToolManager.AnnotationModificationListener() {
                @Override
                public void onAnnotationsAdded(Map<Annot, Integer> map) {
                    ArrayList<Annot> annots = new ArrayList<>(map.keySet());
                    String xfdfCommand = null;
                    try {
                        xfdfCommand = generateXfdfCommand(annots, null, null, component);
                    } catch (PDFNetException e) {
                        e.printStackTrace();
                    }

                    EventChannel.EventSink eventSink = component.getExportAnnotationCommandEventEmitter();
                    if (eventSink != null) {
                        eventSink.success(xfdfCommand);
                    }
                }

                @Override
                public void onAnnotationsPreModify(Map<Annot, Integer> map) {
                }

                @Override
                public void onAnnotationsModified(Map<Annot, Integer> map, Bundle bundle) {
                    ArrayList<Annot> annots = new ArrayList<>(map.keySet());
                    String xfdfCommand = null;
                    try {
                        xfdfCommand = generateXfdfCommand(null, annots, null, component);
                    } catch (PDFNetException e) {
                        e.printStackTrace();
                    }

                    EventChannel.EventSink eventSink = component.getExportAnnotationCommandEventEmitter();
                    if (eventSink != null) {
                        eventSink.success(xfdfCommand);
                    }
                }

                @Override
                public void onAnnotationsPreRemove(Map<Annot, Integer> map) {
                    ArrayList<Annot> annots = new ArrayList<>(map.keySet());
                    String xfdfCommand = null;
                    try {
                        xfdfCommand = generateXfdfCommand(null, null, annots, component);
                    } catch (PDFNetException e) {
                        e.printStackTrace();
                    }

                    EventChannel.EventSink eventSink = component.getExportAnnotationCommandEventEmitter();
                    if (eventSink != null) {
                        eventSink.success(xfdfCommand);
                    }
                }

                @Override
                public void onAnnotationsRemoved(Map<Annot, Integer> map) {

                }

                @Override
                public void onAnnotationsRemovedOnPage(int i) {

                }

                @Override
                public void annotationsCouldNotBeAdded(String s) {

                }
            });
            toolManager.addPdfDocModificationListener(new ToolManager.PdfDocModificationListener() {
                @Override
                public void onBookmarkModified() {
                    String bookmarkJson = null;
                    try {
                        bookmarkJson = generateBookmarkJson(component);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    EventChannel.EventSink eventSink = component.getExportBookmarkEventEmitter();
                    if (eventSink != null) {
                        eventSink.success(bookmarkJson);
                    }
                }

                @Override
                public void onPagesCropped() {

                }

                @Override
                public void onPagesAdded(List<Integer> list) {

                }

                @Override
                public void onPagesDeleted(List<Integer> list) {

                }

                @Override
                public void onPagesRotated(List<Integer> list) {

                }

                @Override
                public void onPageMoved(int i, int i1) {

                }

                @Override
                public void onPageLabelsChanged() {

                }

                @Override
                public void onAllAnnotationsRemoved() {

                }

                @Override
                public void onAnnotationAction() {

                }
            });
        }
    }

    public static void handleDocumentLoaded(ViewActivityComponent component) {
        handleAnnotationModifications(component);

        MethodChannel.Result result = component.getFlutterLoadResult();
        if (result != null) {
            result.success(true);
        }

        if (component.getPdfViewCtrlTabFragment() != null) {
            EventChannel.EventSink documentLoadedEventSink = component.getDocumentLoadedEventEmitter();
            if (documentLoadedEventSink != null) {
                documentLoadedEventSink.success(component.getPdfViewCtrlTabFragment().getFilePath());
            }
        }
    }

    public static boolean handleOpenDocError(ViewActivityComponent component) {
        MethodChannel.Result result = component.getFlutterLoadResult();
        if (result != null) {
            result.success(false);
        }

        return false;
    }

    // Helpers

    private static void checkFunctionPrecondition(ViewActivityComponent component) {
        Objects.requireNonNull(component);
        Objects.requireNonNull(component.getPdfDoc());
    }

    @Nullable
    private static String generateXfdfCommand(ArrayList<Annot> added, ArrayList<Annot> modified, ArrayList<Annot> removed, ViewActivityComponent component) throws PDFNetException {
        PDFDoc pdfDoc = component.getPdfDoc();
        if (pdfDoc != null) {
            FDFDoc fdfDoc = pdfDoc.fdfExtract(added, modified, removed);
            return fdfDoc.saveAsXFDF();
        }
        return null;
    }

    @Nullable
    private static String generateBookmarkJson(ViewActivityComponent component) throws JSONException {
        PDFDoc pdfDoc = component.getPdfDoc();
        if (pdfDoc != null) {
            return BookmarkManager.exportPdfBookmarks(pdfDoc);
        }
        return null;
    }
}
