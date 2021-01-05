package com.android.cast.dlna.control;

import com.android.cast.dlna.DLNACastManager;

import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.Service;

/**
 *
 */
interface IServiceFactory {
    ServiceAction.IAVServiceAction getAvService();

    ServiceAction.IRendererServiceAction getRenderService();

    // ------------------------------------------------------------------------------------------
    // Implement
    // ------------------------------------------------------------------------------------------
    final class ServiceFactoryImpl implements IServiceFactory {
        private final ServiceAction.IAVServiceAction mAvAction;
        private final ServiceAction.IRendererServiceAction mRenderAction;

        public ServiceFactoryImpl(ControlPoint controlPoint, Device<?, ?, ?> device) {
            Service<?, ?> avService = device.findService(DLNACastManager.SERVICE_AV_TRANSPORT);
            mAvAction = new BaseServiceExecutor.AVServiceExecutorImpl(controlPoint, avService);
            Service<?, ?> rendererService = device.findService(DLNACastManager.SERVICE_RENDERING_CONTROL);
            mRenderAction = new BaseServiceExecutor.RendererServiceExecutorImpl(controlPoint, rendererService);
        }

        @Override
        public ServiceAction.IAVServiceAction getAvService() {
            return mAvAction;
        }

        @Override
        public ServiceAction.IRendererServiceAction getRenderService() {
            return mRenderAction;
        }
    }
}